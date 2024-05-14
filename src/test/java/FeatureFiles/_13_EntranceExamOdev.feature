#Senaryo :
#  Exam Formunun Çalışmasını test ediniz
#  1 sınav girişi yapıp
#  sonrasında silmesini yapınız
#  Yukarıdaki adımları 4 farklı değer seti için tekrarlatınız.

Feature: Entrance Exam

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Create new exam and delete
    And Click on the Element in LeftNav
      | entranceExam  |
      | entExSetup    |
      | entranceExam2 |

    And Click on the Element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | <name> |

    And Click on the Element in Dialog
      | gradeLevel |
      | <grade>    |

    And Click on the Element in Dialog
      | academicPeriod |
      | internship     |
      | saveButton     |

    Then Success message should be displayed

    And User delete the Element from Dialog
      | <name> |

    Then Success message should be displayed

    Examples:
      | name   | grade       |
      | mert42 | balistreri  |
      | mert56 | duncan      |
      | mert77 | brittany    |
      | mert61 | breitenberg |
