# DesignPatterns

## Prototype
This is a creational design pattern, which provides guidance on best way to create prototype or clone of an existing object.
There are two ways an object can be clones - Shallow and Deep
In Shallow Copy any object types fields in the original object can be refferd to in the clone copy.
In Deep Copy any object types fields in the original object will be explicitly created a new and then assigned to the clone. Hence clone will hae its own copy of object type fields.

![Image](https://github.com/prakashtanaji/DesignPatterns/blob/master/resources/Prototype.png)



## Chain Of Responsibility
This is a Behavioral design pattern, which provides ability to chain together a hierarchy of request handlers, each with certain privelege.
Each handlers will first examine the request to see if it has authority to respond. If not it will pass the request to its next in chain superior handler.
Each handler will need to have the reference to its next superior handler, ideally to be set at the time of construction of the handler.
Each handler will implement a process/execute method to service the request which will be first called by the client.
All the Handlers needs to implement the interaface method to process the request and set the reference to the next superior handler in order to be part of Chain.

![Image](https://github.com/prakashtanaji/DesignPatterns/blob/master/resources/ChainOfResponsibility.png)


## Singleton
This is a Creational design pattern, which provides ability restrict the instance of a class across the process to one.
There is quote a bit evolution involved in making sure the singleton pattern is correctly implemented. Although the straight forward way to implement it is by making the constructor of the object private to avoid anyone creating the instance and instead provide a static method to return the instance to the caller in controlled manner, by first checking if the instance exists(if not create it) and the return the instance.

Although this approch might work in simple use cases where there are limited callers and its guaranteed that not all need the instance at the same time.
But as the system becomes more complex and many threads run concurrently and needs to singleton instance, the simple implementation of the patterns break.

There are other full proof implementations which ensure †hat object is truly singleton. Understanding the different implementaions of teh pattern and their drawbacks helps in making proper use of this simple design pattern.

![Image](https://github.com/prakashtanaji/DesignPatterns/blob/master/resources/Singleton.png)

## Proxy
This is a Structural design pattern, using which will allow for client to add for validation to provide controlled access to call the real objects methods, without either changing the real class implementation nor the clients which are implemented.

The idea is to create an interface and have clients implement against it. The real object is implements the interface members.
If the clients needs to intercept the calls to the real methods, a proxy is created with reference to the real object, and proay methos could 
perform neccessary validations before calling the real method.

Typically Proxy pattern allows to control access to real implementation after it is built without changing it or its client which are built around the abstracted object.

![Image](https://github.com/prakashtanaji/DesignPatterns/blob/master/resources/Proxy.png)

## Misc
