Feature: Fees multiple values functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Fee Functionality and Delete
    And Click on the Element in LeftNav
      | setup      |
      | parameters |
      | fees       |

    And Click on the Element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput       | <name>     |
      | codeInput       | <code>     |
      | integrationCode | <intCode>  |
      | priorityCode    | <priority> |

    And Click on the Element in Dialog
      | activeButton |
      | saveButton   |

    Then Success message should be displayed

    And User delete the Element from Dialog
      | <name> |

    Then Success message should be displayed

    Examples:
      | name       | code  | intCode  | priority |
      | mert2Fee32 | 23954 | PayPal   | 6789    |
      | mert2Fee45 | 23987 | Cash     | 7863    |
      | mert2Fee56 | 23990 | Cheque   | 8926    |
      | mert2Fee67 | 23933 | ApplePay | 3427    |
      | mert2Fee78 | 23921 | Crypto   | 7352    |