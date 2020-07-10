package com.swat018;

import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
/*        Class<Book> bookClass = Book.class;
        Book book = new Book();

        Class<? extends Book> aClass = book.getClass();

        Class<?> aClass1 = Class.forName("com.swat018.Book");

        Arrays.stream(bookClass.getFields()).forEach(System.out::println);
        System.out.println("-----------------------");
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true);
                System.out.printf("%s %s\n", f, f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        System.out.println("-----------------------");
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);
        System.out.println("-----------------------");
        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);
        System.out.println("-----------------------");
        System.out.println(MyBook.class.getSuperclass());
        System.out.println("-----------------------");
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);
        System.out.println("-----------------------");
        Arrays.stream(Book.class.getDeclaredFields()).forEach(f-> {
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
        });
        System.out.println("-----------------------");
        Arrays.stream(Book.class.getMethods()).forEach(m-> {
            int modifiers = m.getModifiers();
        });*/

//        Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);
//        Arrays.stream(MyBook.class.getDeclaredAnnotations()).forEach(System.out::println);

/*        Arrays.stream(Book.class.getDeclaredFields()).forEach(f->{
            Arrays.stream(f.getAnnotations()).forEach(a-> {
                if(a instanceof MyAnnotation) {
                    MyAnnotation myAnnotation = (MyAnnotation) a;
                    System.out.println(myAnnotation.value());
                    System.out.println(myAnnotation.number());
                }
            });
        });*/

        Class<?> bookClass = Class.forName("com.swat018.Book");
        Constructor<?> constructor = bookClass.getConstructor(String.class);
        Book book = (Book) constructor.newInstance("MyBook");
        System.out.println(book);

        Field a = Book.class.getDeclaredField("A");
        System.out.println(a.get(null));
        a.set(null, "AAAAAAA");
        System.out.println(a.get(null));

        Field b = Book.class.getDeclaredField("B");
        b.setAccessible(true);
        System.out.println(b.get(book));
        b.set(book, "BBBBBBB");
        System.out.println(b.get(book));

        Method c = Book.class.getDeclaredMethod("c");
        c.setAccessible(true);

        Method d = Book.class.getDeclaredMethod("sum", int.class, int.class);
        int invoke = (int) d.invoke(book, 1,2);
        System.out.println(invoke);
    }
}
