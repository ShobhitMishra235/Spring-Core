package in.strikes.JavaCircularDependenciesExample;

public class B {
    private A a;
    public B() {
        this.a = new A();
    }
}
/*

Circular dependency becomes an object-creation problem when A's constructor creates B and B's constructor creates A,
causing infinite recursive object creation when main calls any of the method.








Remember this for Spring

Constructor injection:

A needs B
B needs A

A constructor → needs B
             → B constructor → needs A
                              → A constructor
                              → ❌ Circular dependency

This is why constructor-based circular dependencies are problematic in Spring.

With setter/field injection, Spring can create the objects first and inject the references afterward,
which gives Spring a way to resolve certain circular dependencies.

 */