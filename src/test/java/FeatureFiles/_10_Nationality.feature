#Nationality menusunun kayıt ve silme özelliğini
#DataTable ile 5 farklı değer seti ile çalıştırınız.

Feature: Nationality Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Create Nationality and Delete
    And Click on the Element in LeftNav
      | setup         |
      | parameters    |
      | nationalities |

    And Click on the Element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | <name> |

    And Click on the Element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the Element from Dialog
      | <name> |

    Then Success message should be displayed

    Examples:
      | name    |
      | mert232 |
      | mert245 |
      | mert256 |
      | mert267 |
      | mert278 |