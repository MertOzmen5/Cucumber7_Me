#Inventory Bölümündeki
#Item Categories  Çalışmasını test ediniz, girişi yapıp sonrasında silmesini yapınız

Feature: Inventory Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Create Inventory and Delete
    And Click on the Element in LeftNav
      | inventory      |
      | setupInvent    |
      | itemCategories |

    And Click on the Element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | <name> |

    And Click on the Element in Dialog
      | userType   |
      | student    |
      | saveButton |

    Then Success message should be displayed

    And User delete the Element from Dialog
      | <name> |

    Then Success message should be displayed

    Examples:
      | name    |
      | mert777 |
      | mert778 |
      | mert779 |
