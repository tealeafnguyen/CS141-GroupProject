Tahas-Japanese-Adventure-in-Japan
=================================
Assignment description

For this assignment, this is a team project where we are only required one submission. 
This is a small text-based game that takes place on 81 squares where every square represents 
a possible position for different entities in the game. There are 9 special squares that 
represent rooms which are equally distributed on the grid. The player is to find a briefcase 
in one of the 9 rooms. The building is pitch black and there are six ninjas that will move throughout 
the building. The spy starts at the bottom left-corner of the grid, while the ninjas are randomly spawned 
across the grid, but must be 3 squares away from the spy's initial location if they're spawned too close. 
The briefcase exists in one of 9 rooms. The rooms may only be accessed from the north side. The spy will have
the ability to see 2 squares ahead of the player's current position; the spy is always the first one who 
starts their turn, then the ninjas each take their own turn moving. The spy has a gun with only 1 bullet. 
The spy is allowed to shoot in any direction as long there is ammo, this will take up their turn if they shoot. 
The spy is allowed to look and then take an action, the look feature will detect if there is a ninja ahead in a chosen 
direction. Ninja's start every turn by checking if the player is at an adjacent square, if that is 
the case; then the player is killed, else the ninja moves randomly. There are 3 power-ups in the 
game: additional bullet gives the player an extra bullet, invincibility will prevent the player from dying 
for 5 turns, and the radar will reveal the room with the briefcase. These power-ups are randomly placed across 
the grid. The player will have 3 lives and will lose a life if they are killed. When lives equals 0, then the game 
is over. The player will be allowed to quit the game at any time and save their progress and load that said progress 
or another save file. This program will be designed using object oriented programming.

Team Information

Team Crazy Bananas
Taha Khan
Farzad Kosar
Yool Weeji Jeon (James)
Isaac Gonzalez
Thomas Nguyen

Description of approach for solution

When approaching this project, we first had to decide which classes we would need and what their purpose would be.
This was not too difficult, but we quickly realized that we would need a pretty generous amount of them. When we 
started to think about the number of classes, we realized that using abstract classes as super classes would be 
useful, since there are some subclasses that share attributes and behaviors, but do some of these differently. 
Such as the Ninja and Player classes, these are treated similarly by the mainframe of the program, but they are of
course interacted with by the user in different ways. The Ninja and Player classes are subclasses of the Entity 
abstract class for this reason. Similarly, there is a abstract superclass called PowerUp for the three different
power ups that are included in the game. The utilization of abstract classes for the purpose of our program proved
to be useful later, since we were able to reuse code for many of the behaviors the subclasses would use and it was
easier for our program to realize when it was interacting with something that should have an effect(using instanceof, 
checking if there was an instanceof a certain superclass). Another design choice we quickly decided upon was the 
use of an interface. In the beginning, it became very obvious that if we were to create a program in which a wide 
range of objects from different classes were going to be able to interact with each other, as well as be displayed 
to the user as a grid, we would need to find a way for the classes to be able to relate to one another. We decided 
on creating the GridMember interface. The GridMember interface only has a few methods, but they are very powerful 
for the purpose of the program. The most powerful use of the interface is our ability to group all the objects used
in the game into a two dimensional array of nine by nine, and display them. The interface also allowed us to make 
references to every single spot in the array as an object, which made the entire coding process easier. Each member
of the GridMember interface must have a toString method, which displays the symbol of the object. This method was 
crucial for use in the program, since we were able to go through the array of objects and use the toString method on 
them. One of the most useful methods that members of the interface must implement is the see method. What this method
does is lets an object know if it is “seen” by the player, and if it is seen it will display its true symbol rather 
than the default “dark” symbol. We decided on a pretty simple hierarchy when it came to the interaction of the game
with the user. The Grid would be created and would set up the two dimensional array if all of its members. The Grid 
would also have the methods that actually “moved” things, since the Grid itself would be being altered. The GameEngine
would have methods that got information from the UserInterface, and would translate that information to be passed 
to the methods in the Grid, and the Grid would act accordingly. The UserInterace would get information from the player,
like which direction they wanted to move in and what they wanted to do each turn. In general, we wrote the method 
parameters to only take in primitive data types, because we were only getting that type of data from the user. If
we wrote the methods to have parameters that were objects, we would risk breaking encapsulation, and many methods 
would become to intertwined with other classes. In keeping the methods simple, we were able to keep the program 
modular. We had to realize that the methods we needed to write did not need to know what the information meant, but 
just how to use it. A very useful design choice we decided on was to include a class called EmptyMember, 
that simply implemented the GridMember interface. This class was used to fill up spaces in the array that had no 
important objects in it, such as Rooms, the Player, or Ninjas. These spaces were treated as spaces that the Player 
and Ninja could move into, and always displayed either the symbol for being hidden, or the symbol for being seen(blank symbol).
Writing code for the movement of the player and ninjas as well as the action of the Player seeing one space 
in each direction at all times began to pose some issues at first. The issue was that if the object wanted to 
interact with an index that was out of bounds with the array, the program would crash. It was quickly realized 
that in order to overcome this issue, we had to include much of the code dealing with the indexes in a try-catch 
block, that caught the ArrayIndexOutOfBoundsException. The try-catch blocks became extremely useful, since it took 
care of all of the issues in regards to movement and 'seeing' spaces that were beyond the grid. We were able to write 
code that handled these issues elegantly, and without interrupting the program.	When it came to the movement of the 
Ninjas and Player, we were able to write code that behaved similarly for both of them. The idea is simple, the code 
checks for a direction, once it has that direction, a switch statement is called and depending on the direction passed 
in, alters the coordinates of the object being acted on in accordance to the direction chosen.

Conclusion and Lessons Learned

What we learned from this project was that we should plan before we code because if we had gone halfway through completion
of the project and ended up with a game breaking bug of some sort, or had to rearrange methods and classes; the task
would’ve proved to be arduous and time consuming. Luckily, we were sternly reminded that we should plan out the project
during the first milestone check. The next lesson we learned was that methods should pass around primitive data types
between classes. This is because passing something more complex like an object would break encapsulation for the program.
There is no need for communication between the grid and game engine class if they’re just going to pass around objects. 
Thus we had methods retrieve integers and booleans instead of the objects themselves to keep everything encapsulated.
In the planning stages of the project, we learned the importance of interfaces; that the interface basically made any 
class that implements the interface possess the same methods as the other classes that implemented it. The interface was
incredibly useful when working with groups because it told other members what the method names should be when creating a
new class that would be included in the game. This made it easy to put all the pieces together to create the program as 
a whole. The interface served as a helpful guideline for planning and actually coding individual parts of the game, but 
also that the interfaces should be simple and not too overbearing, Having a few methods that all classes that implement 
it should share is fine, but having an extreme amount would cause a lot of headaches if all the methods weren’t really
needed in some of the classes that had to implement the interface. The next lesson learned was to make each method or
class modular. By maintaining modularity, we are able to find any bug that would occur within the program at runtime. 
This also meant that we could find out who’s code wasn’t working properly. By having each method stand on their own, 
this made testing each method before adding it to the project easy because we didn’t have to wait until the entirety 
of the program was finished. The last lesson learned was that working in groups where everyone had their own busy 
schedule meant that conforming to a certain time to meet would be a great inconvenience. We discovered the greatness 
that is otherwise known as Github where we were able to constantly upload snippets of code and organize ourselves 
without having to meet up in person. This was great because there were members who worked on the project at night 
and some members who worked on it during the day. This was like the google docs of programming.
	
