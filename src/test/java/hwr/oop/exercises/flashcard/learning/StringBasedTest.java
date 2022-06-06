package hwr.oop.exercises.flashcard.learning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringBasedTest {

    @Nested
    class StringBasedQuestionTest{

        Question question;
        @BeforeEach
        void setUp() {
            question = Question.create("Question");
        }

        @Test
        void StringBasedQuestion_IsQuestion(){
            assertThat(question).isInstanceOf(Question.class);
        }

        @Test
        void equals_WorksAsIntended() {
            Question different = new StringBasedQuestion("other");
            Question same = new StringBasedQuestion("Question");

            assertThat(question).isNotEqualTo(different);

            assertThat(question).isEqualTo(same);
            assertThat(question).isEqualTo(question);

            assertThat(question).isNotEqualTo(null);
        }

        @Test
        void HashCode_WorksAsIntended() {
            Question same = new StringBasedQuestion("Question");

            boolean hashCodeIsEqual = question.hashCode() == same.hashCode();
            assertThat(hashCodeIsEqual).isTrue();
        }

        @Test
        void ToString_WorksAsIntended() {
            assertThat(question.toString()).isEqualTo("Question");
        }
    }

    @Nested
    class StringBasedSolutionTest{
        Solution solution;
        @BeforeEach
        void setUp() {
            solution = Solution.create("Solution");
        }

        @Test
        void StringBasedSolution_IsSolution() {
            assertThat(solution).isInstanceOf(Solution.class);
        }

        @Test
        void equals_WorksAsIntended() {
            Solution different = new StringBasedSolution("other");
            Solution same = new StringBasedSolution("Solution");

            assertThat(solution).isNotEqualTo(different);

            assertThat(solution).isEqualTo(same);
            assertThat(solution).isEqualTo(solution);

            assertThat(solution).isNotEqualTo(null);
        }

        @Test
        void HashCode_WorksAsIntended() {
            Solution other = new StringBasedSolution("Solution");

            boolean hashCodeIsEqual = solution.hashCode() == other.hashCode();
            assertThat(hashCodeIsEqual).isTrue();
        }

        @Test
        void ToString_WorksAsIntended() {
            assertThat(solution.toString()).isEqualTo("Solution");
        }

        @Test
        void isSolutionTo_IsTheSolutionOfCard_AnswerIsSolution() {
            Solution solution = new StringBasedSolution("correct");
            FlashCard flashCard = new FancyFlashCard(new StringBasedQuestion(""), solution);

            boolean isSolutionTo = solution.isSolutionTo(flashCard);
            assertThat(isSolutionTo).isTrue();
        }
    }

    @Nested
    class StringBasedAnswerTest{
        Answer answer;
        @BeforeEach
        void setUp() {
            answer = Answer.create("Answer");
        }

        @Test
        void StringBasedAnswer_IsAnswer() {
            assertThat(answer).isInstanceOf(Answer.class);
        }

        @Test
        void equals_WorksAsIntended() {
            Answer different = new StringBasedAnswer("other");
            Answer same = new StringBasedAnswer("Answer");

            assertThat(answer).isNotEqualTo(different);

            assertThat(answer).isEqualTo(same);
            assertThat(answer).isEqualTo(answer);

            assertThat(answer).isNotEqualTo(null);
        }

        @Test
        void HashCode_WorksAsIntended() {
            Answer other = new StringBasedAnswer("Answer");

            boolean hashCodeIsEqual = answer.hashCode() == other.hashCode();
            assertThat(hashCodeIsEqual).isTrue();
        }

        @Test
        void ToString_WorksAsIntended() {
            assertThat(answer.toString()).isEqualTo("Answer");
        }

        @Test
        void isSolutionTo_IsTheSolutionOfCard_IsSolution() {
            Answer correctAnswer = new StringBasedAnswer("correct");
            Solution solution = new StringBasedSolution("correct");
            ArrayList<Answer> answers = new ArrayList<>();
            answers.add(correctAnswer);
            FlashCard flashCard = new FancyFlashCard(new StringBasedQuestion(""), answers, solution);

            boolean isSolutionTo = correctAnswer.isSolutionTo(flashCard);
            assertThat(isSolutionTo).isTrue();
        }
    }

}
