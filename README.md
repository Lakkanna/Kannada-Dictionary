# Kannada-Dictionary Android Application

Functionality:

1. Search kannada word for meaning
2. Add new word meaning 

NOTE: You need to install or setup Kannada keyboard

**** SETUP ****

** Android Studio **
1. Copy Dictionary folder to your android project folder, 
2. Open android studio - click on File -> open project - select Dictionary 
3. It'll starts building gradle, make sure you have internet connection if the gradle is not set properly it'll download some libraries.
4. Once successfully gradle is done go to java file called Constants.java
5. private static final String ROOT_URL = "http://192.168.43.251/Dictionary_Server/"; here you have to use the IP Adress of your system.
6. for this your phone and laptop should be connected to same wifi network. (Turn hotspot in phone and connect that wifi in laptop).
7. open command prompt -> type ipconfig -> hit enter
8. in command prompt find "Wireless LAN adapter Wi-Fi:" in that  "IPv4 Address"-> "192.168.43.251" this your IP Adress so copy this in Constants.java ROOT_URL variable
9. example private static final String ROOT_URL = "http://192.168.43.251/Dictionary_Server/"; here 192.168.43.251 is mine replace ip adress of your system there.
10. make sure that firewall is not blocking apache. if u did not get output in app try onec by turn off the firewall.

** Wamp server ** or Xampp server here im using Wamp server
1. Copy Dictionary_Server folder in your wamp server -> www folder
2. make sure that in addDetails.php and getDetails.php give your localhost credentials, hostname and password of yours, default will localhost and password empty.
3. for running localhost on phone make changes in your apche server
4. wamp-> bin -> apache -> apache2.4-> conf -> extra -> "httpd-vhosts.conf" open this file in notepad or any text editor.
5. find "Require" word and replace that whole line with Require all granted
6. Save and exit text editor
7. Restart your wamp server
		
** Database **
1. Create new database called "Dictionary"
2. Click on import select dictionary.sql file from Dictionary_Server folder. 
	
