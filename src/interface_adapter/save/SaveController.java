package interface_adapter.save;

import entity.Recipe;
import interface_adapter.SearchController;
import use_case.save.SaveInputBoundary;
import use_case.save.SaveInputData;

import java.util.ArrayList;

public class SaveController implements SearchController {
    private final SaveInputBoundary saveInteractor;

    public SaveController(SaveInputBoundary saveInteractor) {
        this.saveInteractor = saveInteractor;
    }

    public void execute(Integer recipeID) {
        SaveInputData saveInputData = new SaveInputData(recipeID);
        saveInteractor.execute(saveInputData);
    }
}
