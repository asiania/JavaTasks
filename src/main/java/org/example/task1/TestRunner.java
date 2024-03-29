package org.example.task1;

import java.lang.reflect.Method;
import java.util.*;

public class TestRunner {
    static <T> void runTests(Class<T> c) throws Exception {
        int beforeSuiteAnnotationCount = 0;
        Method beforeSuiteMethod = null;
        int afterSuiteAnnotationCount = 0;
        Method afterSuiteMethod = null;

        Method[] methods = c.getDeclaredMethods();
        List<Method> methodsBeforeTest = new ArrayList<>();
        List<Method> methodsAfterTest = new ArrayList<>();
        Map<Integer, List<Method>> methodsTest = new HashMap<>();
        Map<Method, String> methodsArgs = new HashMap<>();
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)){
                beforeSuiteAnnotationCount++;
                beforeSuiteMethod = m;
            }
            if (m.isAnnotationPresent(AfterSuite.class)){
                afterSuiteAnnotationCount++;
                afterSuiteMethod = m;
            }
            if (m.isAnnotationPresent(BeforeTest.class)){
                methodsBeforeTest.add(m);
            }
            if (m.isAnnotationPresent(AfterTest.class)){
                methodsAfterTest.add(m);
            }

            if (m.isAnnotationPresent(Test.class)){
                Test test  = m.getAnnotation(Test.class);
                CsvSource csvSource  = m.getAnnotation(CsvSource.class);
                if (!methodsTest.containsKey(test.priority())) methodsTest.put(test.priority(), new ArrayList<>());
                methodsTest.get(test.priority()).add(m);
                methodsArgs.put(m, csvSource.value());
            }
        }

        if(beforeSuiteAnnotationCount > 1 || afterSuiteAnnotationCount>1){
            throw new Exception("BeforeSuite or AfterSuite Annotation > 1");
        }

        if(beforeSuiteMethod != null)
            beforeSuiteMethod.invoke(null);

        for(int i=1; i <= 10; i++){
            if (methodsTest.containsKey(i)){
                for (Method m : methodsBeforeTest) {
                    m.invoke(null);
                }

                for (Method m : methodsTest.get(i)) {
                    Class<T>[] classParams = (Class<T>[]) m.getParameterTypes();
                    List<String> listParams = Arrays.asList(methodsArgs.get(m).split(","));
                    Object[] arrayParams = new Object[listParams.size()];
                    for(int j=0; j < arrayParams.length; j++){
                        if(classParams[j].getName().equals("boolean")){
                            arrayParams[j] = Boolean.parseBoolean(listParams.get(j).trim());
                        }
                        else if(classParams[j].getName().equals("int") || classParams[j].getName().equals("Integer")){
                            arrayParams[j] = Integer.parseInt(listParams.get(j).trim());
                        }
                        else arrayParams[j] = classParams[j].cast(listParams.get(j).trim());
                    }
                    Object obj = ((Class<?>) c).newInstance();
                    m.invoke(obj,arrayParams);

                }

                for (Method m : methodsAfterTest) {
                    m.invoke(null);
                }
            }
        }

        if(afterSuiteMethod != null)
            afterSuiteMethod.invoke(null);
    }
}
