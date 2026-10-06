package in.strikes.JavaCircularDependenciesExample;

public class A {
    private B b;
    public A() {
        this.b = new B();
    }
}
