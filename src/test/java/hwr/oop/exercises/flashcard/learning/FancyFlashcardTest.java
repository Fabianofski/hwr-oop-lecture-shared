package hwr.oop.exercises.flashcard.learning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class FancyFlashcardTest {

    private Question question;
    private ArrayList<Answer> answers;
    private Solution solution;
    private FlashCard flashCard;

    @BeforeEach
    void setUp() {
        question = new StringBasedQuestion("This is a question");
        answers = new ArrayList<>();
        for (int i = 1; i < 4; i++) answers.add(new StringBasedAnswer(i + ". Answer"));
        solution = new StringBasedSolution("3. Answer");
        flashCard = new FancyFlashCard(question, answers, solution);
    }

    @Test
    void assertValidFlashCard_ProvidedNoQuestionNoAnswer_ThrowsIllegalArgumentException() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            FancyFlashCard card = new FancyFlashCard(null, null);
        });
    }

    @Test
    void assertValidFlashCard_ProvidedSolutionNotInAnswers_ThrowsIllegalArgumentException() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            FancyFlashCard card = new FancyFlashCard(
                    question,
                    answers,
                    new StringBasedSolution("")
            );
        });
    }

    @Test
    void equalsHashCode_ProvideEqual_AreEqual() {
        FancyFlashCard other = new FancyFlashCard(question, answers, solution);
        assertThat(flashCard).isEqualTo(other);

        boolean hashCodeIsEqual = flashCard.hashCode() == other.hashCode();
        assertThat(hashCodeIsEqual).isTrue();

        assertThat(flashCard).isEqualTo(flashCard);

        assertThat(flashCard).isNotEqualTo(null);
    }

    @Test
    void getQuestionGetSolution_ProvidedQuestionProvidedSolution_EqualProvided() {
        assertThat(question).isEqualTo(flashCard.getQuestion());
        assertThat(solution).isEqualTo(flashCard.getSolution());
    }

    @Test
    void getOptions_ProvidedAnswers_ReturnsPresentNonEmptyOptional() {
        Optional<Collection<Answer>> optionalAnswers = flashCard.getOptions();
        assertThat(optionalAnswers).isPresent().isNotEmpty();
    }

    @Test
    void getOptions_ProvidedNoAnswers_ReturnsNonPresentEmptyOptional() {
        FlashCard card = new FancyFlashCard(question, solution);
        Optional<Collection<Answer>> optionalAnswers = card.getOptions();
        assertThat(optionalAnswers).isNotPresent().isEmpty();
    }

    @Test
    void isCorrectAnswer_ProvidedNull_ThrowsIllegalArgumentException() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            flashCard.isCorrectAnswer(null);
        });
    }

    @Test
    void isCorrectAnswer_ProvidedSolution_IsCorrectAnswer() {
        boolean answerIsCorrect =  flashCard.isCorrectAnswer(new StringBasedAnswer(solution.toString()));
        assertThat(answerIsCorrect).isTrue();
    }

    @Test
    void isCorrectAnswer_ProvidedWrongAnswer_IsNotCorrectAnswer() {
        boolean answerIsCorrect =  flashCard.isCorrectAnswer(new StringBasedAnswer("Wrong Answer"));
        assertThat(answerIsCorrect).isFalse();
    }
}
