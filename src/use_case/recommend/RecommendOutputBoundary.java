package use_case.recommend;

public interface RecommendOutputBoundary {

    void prepareSuccessView(RecommendOutputData user);

    void prepareFailView(String error);

}
