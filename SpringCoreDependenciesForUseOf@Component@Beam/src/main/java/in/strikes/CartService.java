package in.strikes;

public class CartService {
    public void addToCart() {
        System.out.println("Added to cart");
    }
}
/*

You write:

java -jar CartApp.jar

in the terminal/command prompt, not inside your Java code.

In IntelliJ IDEA
Open your project.
Open the Terminal at the bottom.

Navigate to the folder containing your JAR, for example:

cd target

Then run:

java -jar CartApp.jar

For example, if Maven created:

MyProject
└── target
    └── CartApp-1.0-SNAPSHOT.jar

you would run:

java -jar CartApp-1.0-SNAPSHOT.jar
Important

If you're simply adding the JAR as a dependency to another Maven project, you normally don't write java -jar at all.

You add the dependency in pom.xml, then use its classes:

Cart cart = new Cart();
cart.addProduct();

Your own project's main() starts the application.

So:

java -jar
   ↓
Terminal
   ↓
Used when you want to RUN the JAR itself

whereas:

pom.xml
   ↓
dependency
   ↓
Used when another project wants to USE the JAR
can you tell me an example write the code and output

Absolutely. Let's make a very simple example showing both cases:

Create an executable JAR
Use that executable JAR as a dependency in another project
See what actually runs
1. Project A — Create CartApp.jar

Suppose Project A has this class:

package com.example.cart;

public class Cart {

    public void addProduct() {
        System.out.println("Product added to cart!");
    }

    public static void main(String[] args) {
        System.out.println("Cart application started!");

        Cart cart = new Cart();
        cart.addProduct();
    }
}

Here we have both:

public void addProduct()

and

public static void main(String[] args)

So this JAR can be made executable.

If you run it directly

In the terminal:

java -jar CartApp.jar

Output:

Cart application started!
Product added to cart!

Because Java finds:

main()
   ↓
Cart
   ↓
addProduct()
2. Now use CartApp.jar in another project

Suppose you create Project B.

Project B has:

package com.example.app;

import com.example.cart.Cart;

public class MyApplication {

    public static void main(String[] args) {

        System.out.println("My application started!");

        Cart cart = new Cart();
        cart.addProduct();
    }
}

You add CartApp.jar as a dependency.

Now run Project B.

The output is:

My application started!
Product added to cart!
Notice something important

This:

public static void main(String[] args) {
    System.out.println("Cart application started!");
}

from CartApp.jar did NOT execute.

Why?

Because you started Project B.

The execution was:

Project B
   ↓
MyApplication.main()
   ↓
new Cart()
   ↓
cart.addProduct()

The main() inside the dependency JAR is just sitting there. It doesn't automatically run.

3. Compare the two situations
Running the JAR directly
java -jar CartApp.jar

Execution:

CartApp.jar
     ↓
Cart.main()
     ↓
"Cart application started!"
     ↓
addProduct()

Output:

Cart application started!
Product added to cart!
Using the JAR as a dependency
MyApplication
      ↓
MyApplication.main()
      ↓
new Cart()
      ↓
addProduct()

Output:

My application started!
Product added to cart!

The main() of Cart doesn't run.

4. What if the JAR didn't have main()?

You could have:

public class Cart {

    public void addProduct() {
        System.out.println("Product added!");
    }
}

This is still a perfectly valid JAR.

You cannot normally run it directly with:

java -jar Cart.jar

But you can absolutely use it as a dependency:

Cart cart = new Cart();
cart.addProduct();

Output:

Product added!
The main idea

Think of main() as the starting door of an application.

Executable JAR

        main()
          ↓
     starts program

But when that JAR is used as a dependency:

Your application's main()
          ↓
     uses classes
          ↓
      dependency JAR

So having main() does not change how the classes inside the JAR are used as dependencies. It only gives the JAR the additional ability to be launched directly.

 */