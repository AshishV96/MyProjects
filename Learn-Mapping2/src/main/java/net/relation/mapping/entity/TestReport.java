package net.relation.mapping.entity;

import com.caone.eezypost.api.contracts.test.CodeSubmitContract;
import com.caone.eezypost.api.contracts.test.ReportQuesAnsContract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestReport {

    private String testId;

    private TestStatus testStatus;

    private String employerId;

    private String email;

    private String firstName;

    private String lastName;

    private LocalDateTime submittedOn;

    private int numberOfQuestions;

    private int numberOfQuestionsAttempted;

    private double testScore;

    private double testTotalMarks;

    private int faceDetected;

    private int faceNotDetected;

    private int faceMoved;

    private int voiceDetected;

    private int testCompletionTime;

    private String encodedImage;

    private String testName;

    private String userInfo;

    private LocalDateTime createdOn;

    private List<ReportQuesAnsContract> submittedQuesAns;

    private List<CodeSubmitContract> codeSubmitContracts;

    private String linkedinURL;

    private Boolean hrEvaluation = false;

    private Boolean linkedinEvaluation = false;

    private String submittedHrAnswer;

    private Double hrQuestionsWeightage;

    private TestSentType testSentType;

    private String linkedInInformations;

    private String skillsToCheck;

    private TemplateType templateType;

    }
}
