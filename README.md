# Sheep_Herder_Game

📝 INSTRUCTION: 
Create a game called Sheep Herder. The idea of the game is to herd the sheep
(find) before the sheep are eaten. Simply put, the user chooses spots in a grid and 
if it is a sheep, the sheep was herded.

In the game there will also be a dog and a wolf. If found, the dog will help in two 
ways: 
1. Give the user an extra turn.
2. Fight the wolf if the wolf attacks you.

If found, the wolf will attack you and you will lose unless you already found the 
dog. 

All animals have a random strength value (str). This will come in to play when the 
dog defends you from the wolf or the wolf bumps into the dog. Say the Dog str = 
10 and the wolf’s str = 8. Well your dog would win and survive with only 2 left 
over and the poor wolf dies. But what if it was vise versa? Your dog would have 
died and the wolf survives with str = 2. But happily you still survive in either 
scenario. 

Now the game starts and the computer creates a 5x5 grid and randomly chooses a 
coordinate to put the sheep, dog and wolf. Normally the user cannot see where
they are but for this assignment I want to be able to see all of them for testing 
purposes. Make it similar to the example provided below.

In each turn the user gets to choose a coordinate and then the wolf moves. You 
get to decide how smart that wolf is. Does it move by smell or random? But if 
that wolf hits the sheep, the sheep is no more and the game ends.

![PlayerSheep](https://user-images.githubusercontent.com/105072341/193643043-947be15d-aa38-4c88-894c-8f067a6b8528.jpg)
![Wolf](https://user-images.githubusercontent.com/105072341/193643597-de919b4e-6d54-4de1-80ac-4e876cd1d015.jpg)
![Dog](https://user-images.githubusercontent.com/105072341/193643669-f9d381f3-0e67-4d60-8291-1a131f433c18.jpg)


