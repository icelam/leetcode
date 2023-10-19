import pandas as pd

def createBonusColumn(employees: pd.DataFrame) -> pd.DataFrame:
    result_dataframe = pd.DataFrame(employees)
    result_dataframe['bonus'] = employees['salary'] * 2
    return result_dataframe
