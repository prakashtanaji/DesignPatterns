package chain;

object ChainOfResponsibility {
    def main(args:Array[String]) {
        var president = new President();
        var director = new Director(president);
        var manager = new Manager(director);

        println(manager.process(""));
    }
}

trait MgmtLayer {
    var nextMgmt : MgmtLayer;
    def process(input: String): String;
    // def this(next : MgmtLayer) {
    //     this();
    //     nextMgmt = next;
    // }
}

class Manager extends MgmtLayer {

    def this(next : MgmtLayer) {
        this();
        nextMgmt = next;
    }
    def process(input: String): String {
        var inputRes: String = input + "Inside Manager";

        // if expression
        if(nextMgmt == null) return inputRes;
        else return nextMgmt.process(inputRes);
    }
}

class Director extends MgmtLayer {
    def this(next : MgmtLayer) {
        this();
        nextMgmt = next;
    }
    def process(input: String): String {
        var inputRes: String = input + "Inside Director\n";

        inputRes = 
        if(nextMgmt == null) inputRes;
        else nextMgmt.process(inputRes);
    }
}

class President extends MgmtLayer {
    def this(next : MgmtLayer) {
        this();
        nextMgmt = next;
    }
    def process(): String {
        var inputRes: String = "Inside President\n";

        inputRes = 
        if(nextMgmt == null) inputRes;
        else nextMgmt.process(inputRes);
    }
}