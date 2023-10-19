import pandas as pd

def modifySalaryColumn(employees: pd.DataFrame) -> pd.DataFrame:
    result_dataframe = pd.DataFrame(employees)
    result_dataframe['salary'] = employees['salary'] * 2
    return result_dataframe
