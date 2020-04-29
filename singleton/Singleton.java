package singleton;

import java.util.Random;

class Singleton {

    private static Singleton _instance;
    private int randomVal;

    private Singleton() {
        Random rand = new Random();
        randomVal = rand.nextInt();

    }

    public int getRandomVal() {
        return this.randomVal;
    }

    public static Singleton getInstance() {
        if(_instance == null) {
            // Drawback:
            // Its possible for two thread to enter ths block at 
            // the same time and result in two instances creation
            _instance = new Singleton();
        }
        return _instance;
    }

    public static Singleton getInstanceWithLock() {
        synchronized(Singleton.class) {
            // Having synchronization block solves to avoid creating multiple instances above
            // Drawback: Each call to retrieve singleton instance needs to wait to get the lock
            // thus un-necessary wait and delay
            if(_instance == null) {
                _instance = new Singleton();
            }    
        }

        return _instance;
    }

    public static Singleton getInstanceWithDoubleNullCheck() {
        // The double check for null helps to avoid wait for lock for each instance request
        // The synchronization/lock block will be entered by initial callers and
        // subsequent calls will not enter into the sync block as the instance will be created by then.
        if(_instance == null) {
            synchronized(Singleton.class) {
                if(_instance == null) {
                    _instance = new Singleton();
                }    
            }
        }

        return _instance;
    }
}

class Solution {
    public static void main(String[] args) {

        int randomFromInstance = 0;
        int randomFromInstance2 = 0;
        // This might result in returning multiple instance if called in quick succession.
        // Singleton singleInstance = Singleton.getInstance();
        // randomFromInstance = singleInstance.getRandomVal();

        // This will make sure only one instance is created returned always, but costs in waiting to aquire lock
        // Singleton singleInstance = Singleton.getInstanceWithLock();
        // randomFromInstance = singleInstance.getRandomVal();

        // This is the ideal soluiton to only enter for lock in case there is no instance found and again wait for lock to create instance
        // The double check will occur only for first few requests, as later on the first null check will evaluate to be false hence will not enter the block
        Singleton singleInstance = Singleton.getInstanceWithDoubleNullCheck();
        randomFromInstance = singleInstance.getRandomVal();

        Singleton singleInstance2 = Singleton.getInstance();
        randomFromInstance2 = singleInstance2.getRandomVal();

        System.out.println("The randomVal of the single instance is " + randomFromInstance);
        System.out.println("The randomVal of the single instance 2  is " + randomFromInstance2);
    }
}