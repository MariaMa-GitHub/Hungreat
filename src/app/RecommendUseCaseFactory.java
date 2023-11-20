package app;

import entity.NutritionDataFactory;
import entity.RecipeFactory;
import entity.RecipeInfoFactory;
import interface_adapter.DisplayViewModel;
import interface_adapter.recommend.RecommendController;
import interface_adapter.recommend.RecommendPresenter;
import use_case.recommend.RecommendDataAccessInterface;
import use_case.recommend.RecommendInputBoundary;
import use_case.recommend.RecommendInteractor;
import use_case.recommend.RecommendOutputBoundary;

import javax.swing.*;
import java.io.IOException;

public class RecommendUseCaseFactory {

    private RecommendUseCaseFactory() {}

    public static RecommendController create(RecommendDataAccessInterface dataAccessObject, DisplayViewModel displayViewModel) {

        try {
            RecommendController recommendController = createRecommendUseCase(dataAccessObject, displayViewModel);
            return recommendController;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open data file.");
        }

        return null;
    }

    private static RecommendController createRecommendUseCase(RecommendDataAccessInterface dataAccessObject, DisplayViewModel displayViewModel) throws IOException {

        RecommendOutputBoundary recommendOutputBoundary = new RecommendPresenter(displayViewModel);

        RecipeFactory recipeFactory = new RecipeFactory();
        RecipeInfoFactory recipeInfoFactory = new RecipeInfoFactory();
        NutritionDataFactory nutritionDataFactory = new NutritionDataFactory();

        RecommendInputBoundary recommendInteractor = new RecommendInteractor(dataAccessObject, recommendOutputBoundary, recipeFactory, recipeInfoFactory, nutritionDataFactory);

        return new RecommendController(recommendInteractor);
    }
    
}