# DesignPatterns

## Prototype Design pattern
This is a creational design pattern, which provides guidance on best way to create prototype or clone of an existing object.
There are two ways an object can be clones - Shallow and Deep
In Shallow Copy any object types fields in the original object can be refferd to in the clone copy.
In Deep Copy any object types fields in the original object will be explicitly created a new and then assigned to the clone. Hence clone will hae its own copy of object type fields.

![Image](https://photos.app.goo.gl/rYAxENu4gr4xhFpf9)



## Chain Of Responsibility Design pattern
This is a Behavioral design pattern, which provides ability to chain together a hierarchy of request handlers, each with certain privelege.
Each handlers will first examine the request to see if it has authority to respond. If not it will pass the request to its next in chain superior handler.
Each handler will need to have the reference to its next superior handler, ideally to be set at the time of construction of the handler.
Each handler will implement a process/execute method to service the request which will be first called by the client.
All the Handlers needs to implement the interaface method to process the request and set the reference to the next superior handler in order to be part of Chain.

![Image](https://photos.app.goo.gl/m1rysTjVKeJGnJeB6)


## Misc
