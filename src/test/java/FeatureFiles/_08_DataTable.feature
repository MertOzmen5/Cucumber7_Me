Feature: DataTable Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Create Country
    And Click on the Element in LeftNav
      | setup      |
      | parameters |
      | countries  |

    And Click on the Element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | mertUlk1194 |
      | codeInput | meKod11     |

    And Click on the Element in Dialog
      | saveButton |

    Then Success message should be displayed

  #  And User delete the Element from Dialog
  #   | mertUlk1192 |

  #  Then Success message should be displayed

  Scenario: CitizenShip Create

    And Click on the Element in LeftNav
      | setup       |
      | parameters  |
      | citizenship |

    And Click on the Element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput  | mertCit1194   |
      | shortInput | mertShort1194 |

    And Click on the Element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the Element from Dialog
      | mertCit1194 |

    Then Success message should be displayed

  Scenario: Create Nationality and Delete

    And Click on the Element in LeftNav
      | setup         |
      | parameters    |
      | nationalities |

    And Click on the Element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | turkishMert |

    And Click on the Element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the Element from Dialog
      | turkishMert |

    Then Success message should be displayed

  Scenario: Fee Functionality and Delete

    And Click on the Element in LeftNav
      | setup      |
      | parameters |
      | fees       |

    And Click on the Element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput       | feeMert07775  |
      | codeInput       | meKod111123   |
      | integrationCode | mertKod111123 |
      | priority        | 4             |

    And Click on the Element in Dialog
      | activeButton |
      | saveAndClose |

    Then Success message should be displayed

    And User delete the Element from Dialog
      | feeMert07775 |

    Then Success message should be displayed




