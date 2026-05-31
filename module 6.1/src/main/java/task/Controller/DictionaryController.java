//The DictionaryController class (Controller) is responsible for the dictionary's functionality.
//It should interact with the Dictionary class to perform the search operation.

//Use the methods from the DictionaryController class to interact with the dictionary in the user interface.
//For example, when the search button is pressed, the controller should search for the word in the dictionary.

//Handle cases where the user enters an empty word or when the word is not found in the dictionary.
//Provide appropriate feedback to the user in the user interface.

//Test your application by entering various words and verifying that the correct meanings are displayed.
//Also, test for cases where the word is not found in the dictionary and ensure appropriate feedback is given.
package task.Controller;

import task.Model.Dictionary;
import task.View.DictionaryView;

public class DictionaryController {
    private final DictionaryView gui;
    private final Dictionary dict = new Dictionary();
    public DictionaryController(DictionaryView gui) {
        System.out.println("Dictionary created, "+dict);
        this.gui = gui;
    }

    public void addEntry(String entry, String value){
        if (entry == null || value == null || entry.isEmpty() || value.isEmpty()){
            gui.setResult("Neither input field can be empty.");
        } else{
            String result = dict.get(entry);
            if (result == null){
                dict.add(entry, value);
                gui.setResult("'"+entry+"' added!");
            } else {
                gui.setResult("'"+entry+"' already exists in dictionary!\n"+entry+":\n"+result);
            }
        }
    }
    public void search(String entry){
        String result = dict.get(entry);
        if  (result == null || result.isEmpty()){
            gui.setResult("No results.");
        } else {
            gui.setResult(entry+":\n"+result);
        }
    }
}