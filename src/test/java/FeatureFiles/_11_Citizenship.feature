#Citizenship menusunun kayıt ve silme özelliğini
#DataTable ile 5 farklı değer seti ile çalıştırınız.

Feature: Citizenship Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Create Citizenship and Delete
    And Click on the Element in LeftNav
      | setup       |
      | parameters  |
      | citizenship |

    And Click on the Element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput  | <name>      |
      | shortInput | <shortname> |

    And Click on the Element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the Element from Dialog
      | <name> |

    Then Success message should be displayed

    Examples:
      | name    | shortname |
      | mert232 | me345     |
      | mert245 | me567     |
      | mert256 | me211     |
      | mert267 | me56789   |
      | mert278 | me12321   |