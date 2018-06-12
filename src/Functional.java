import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Functional {
    public static void main(String[] args) {
        //m1();
        //m2();
        //m3();
       // m4();
          //m5();
            //m6();
            //sorting();
                //optional();
                streams();
    }

    private static void m1(){
        Predicate<Integer>isPositive=x->x>0;
        System.out.println(isPositive.test(5));
        System.out.println(isPositive.test(-7));
        System.out.println(isPositive(-12));

                List<Integer>numbers= Arrays.asList(1,2,3,4,5,6);
        System.out.println(sumAll(numbers,n->true));
        System.out.println(sumAll(numbers,n->n%2==0));
        System.out.println(sumAll(numbers,n->n>3));

    }
    private static int sumAll(List<Integer>numbers,Predicate<Integer>p){
    int total=0;
    for(int number:numbers){
        if(p.test(number)){
            total+=number;
        }
    } return total;

    }
    private static boolean isPositive(Integer num){
        return num>0;
    }

    private static void m2(){
        BinaryOperator<Integer>multiply=(x,y)->x*y;
        System.out.println(multiply.apply(3,5));
        System.out.println(multiply.apply(10,-2));

        BinaryOperator<StringBuilder> op= (sb1,sb2)->sb1.append(sb2);
        System.out.println(op.apply(new StringBuilder("This is "),new StringBuilder("Java 8 ")));
    }
    private static void m3(){
        UnaryOperator<Integer>square=x->x*x;
        System.out.println(square.apply(5));
       // UnaryOperator<StringBuilder> op= sb->reverseAndToLowerCase(sb);
       // System.out.println(op.apply(new StringBuilder("Java eight")));
    }
   /** private static StringBuilder reverseAndToLowerCase(StringBuilder sb){
        return new StringBuilder(sb.insert(0,"it-courses.by"))
                .append(".html")
                .toString()
                .replace(" ","_")
                .toLowerCase();
    } **/
            private static void m4(){
                Function<Integer,String>convert=x->String.valueOf(x)+" dollars";
                Function<String,Integer>stringToNumber=x->Integer.valueOf(x)*100;
                System.out.println(convert.apply(5));
                System.out.println(stringToNumber.apply("120"));
            }


            private static void m5(){
                Consumer<Integer>printer=x-> System.out.printf("%d dollars \n",x);
                printer.accept(600);
            }
            private static void m6(){
                Supplier<User>userFactory=()->{
                    Scanner in=new Scanner(System.in);
                    System.out.println("Enter name");
                    String name=in.nextLine();
                    return new User(name);
                };
                User user1=userFactory.get();
                User user2=userFactory.get();
                System.out.println(user1.getName());
                System.out.println(user2.getName());
            }
            static class User{
                private String name;
                String getName()
                {
                    return name;
                }
                User(String n){
                    this.name=n;
                }
            }

            private static void sorting(){
                List<String>names=Arrays.asList("peter","anna","mike","xenia");
                Collections.sort(names);
                Comparator<String> reverseComparator= Comparator.reverseOrder();
                Collections.sort(names,reverseComparator);
                System.out.println(names);
                }


            private static void optional(){
                List<String>StringNumbers=Arrays.asList("9","two","2",null);
                Optional<Integer>op1=stringToNumber(StringNumbers.get(0));
                        Optional<Integer>op2=stringToNumber(StringNumbers.get(3));
                        if(op1.isPresent()){
                            System.out.println(op1.get());
                        }
                        if(op2.isPresent()){
                            System.out.println(op2.get());
                        }

            }
            private static Optional<Integer>stringToNumber(String string){
            Optional<Integer> result;
            try{
                result=Optional.ofNullable(Integer.valueOf(string));
            }catch(NumberFormatException e){
                result=Optional.empty();
            }
            return result;
            }
            private static void streams(){
                List<String>Strings=Arrays.asList("ddd2","aaa2","bbb1","aaa1","bbb3","ccc","bbb2","ddd1");
                Strings.stream()
                        .sorted()
                        .sorted((a,b)->b.compareTo(a))
                        //.count() //конечная
                        .filter((s)->s.startsWith("a"))
                        .map(String::toUpperCase)
                        .map(User::new)
                        .collect(Collectors.toList())
                        .forEach(System.out::println);

            }
}

