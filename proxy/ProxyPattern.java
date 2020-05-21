package proxy;

public class ProxyPattern {

    public static void main(String[] args) {

        Real realObj = new Real();

        // The real implementation is wrapped inside a proxy to allow for additional 
        // validation to decide if the real method can be called.
        // Typically Proxy pattern allows to control access to real implementation after 
        // it is built without changing it or its client which are built around the abstracted object
        Proxy proxy = new Proxy(realObj);

        
        proxy.execute("fake");
        proxy.execute("NotFake");
    }
}

interface IProxy {
    public void execute(String input); 
}

class Real implements IProxy {
    public void execute(final String input) {
        System.out.println("Processing input " + input + " from Real object.");
    }
}

class Proxy implements IProxy {
    IProxy real;
    public Proxy(IProxy real) {
        this.real = real;
    }
    public void execute(final String input) {
        if (input == "fake") {
            System.out.println("Not authorized to call real object with input = " + input);
            return;
        }
        System.out.println("Authorized to call real object with input = " + input);
        real.execute(input);
    }
}