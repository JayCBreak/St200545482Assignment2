# Minecraft Java Server API - Assignment 2
### COMP 1011 - Advanced Object-Oriented Programming Java

### Jacob Chotenovsky - 200545482

This is my submission for COMP 1011's Assignment 2.

## Getting Familiar
This project relys on both the [Minecraft Server Status API](https://api.mcsrvstat.us/) and
[Crafatar API](https://crafatar.com/) to work. When building this project the Crafatar API went down for several days.
This will mean that when the user clicks the "Show Players" button the program will likely crash. As of writing days
before the due date, the API is back up and running consistently. Both APIs are completely free with no keys, tokens,
or accounts required to access it and no limits to worry about hitting. HOWEVER, The McSrvStat API is limited in nature 
as it requires you to provide it a server's IP address. Feel free to use one of the ones listed below to show that HTTP
reponse is working. In the case the servers have no one playing or too many people playing the API will refuse to 
provide any players to load into the tableView object. To show that all functions of the program are working there
is a server.json file that is a capture of Nov. 29th 2023 in which several players were online at the same time. This
json file can be accessed by clicking the **"LOAD EXAMPLE"** button within the program.  Otherwise you can input a
hostname, ip and optionally append a port with :25565 into the box and press "Search Server" to get it's info.

## Example Servers:
 - systembreak.xyz
 - play.torrentsmp.com
 - mc.hypixel.net
 - play.vulengate.com

## Find More Servers [HERE](https://findmcserver.com/servers)
Filter for JAVA servers and 0-25 players for your best chance at finding servers that show players who are connected.
Not all allow you to see who is playing on them.