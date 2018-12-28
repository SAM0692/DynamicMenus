# DynamicMenus

This is the AirTable Dynamic Menus Homework.

It is a small web application that shows a dynamic menu using data retreived from the CONFIG table in the Airtable
Dev Homework - DynamicMenus base.

Using the AirTable Java API, I accessed the CONFIG table and retrieved all the records that fullfilled the criteria of:

1. The value of the Live field must be 1 (or true).
2. The Actions fields cannot be empty.
3. The URL field cannont be empty.

To manage the data more easily I created 3 classes: Menu, SubMenu and MenuItem. The relations between these goes as follows:

1. A Menu can have a list of SubMenu objects or, in the lack of a Submenu as is in the case of the Develop Material menu, a list
   of MenuItems.
2. A SubMenu can have a list of MenuItem objects.

Doing it like this I was able to group them one inside another as fit for each case.

Finally to present it all in the view I used JSF framework in order to have easy access to the objects from the layout file
directly to the Java Class. Iterating to list of Menu objects I created in the Class I created the first level and for the contents
of each menu Iterated its SubMenu list and retrived the corresponding MenuItem list or, if said lis was empty, directly retrieved
the MenuItem list corresponding the the Menu.

The technologies used for this application where:
- Java EE.
- JSF.
- Maven.
- AirTable, using the Java API.

In order to run this application you can deploy it in a application server that has a JVM.

I've also created s standalone option.
