Feature: Datatable Örnek

  Scenario: Users List
    When write username "mert"
    And write username and password "mert" and "1234"

    And write username as DataTable
      | mert  |
      | ismet |
      | ali   |
      | ayse  |
      | fatma |

    And write username and password as DataTable
      | mert  | 1234    |
      | ismet | 3456    |
      | ali   | 68965   |
      | ayse  | 3543027 |
      | fatma | 122304  |
      | ahmet | 45      |

    # dataProvider (TestNG için),karşılığı Senaryo Outline (cucumber)
  # görevi verilen her değer için tüm senaryo çalışır

  # DataTable ise ,sadece bir step e, çoklu parametre vermek  için kullanılır sadece 1 kez tüm parametreleri stepin içine atar