import pandas as pd

def renameColumns(students: pd.DataFrame) -> pd.DataFrame:
    old_column_names = students.columns
    new_column_names = ['student_id', 'first_name', 'last_name', 'age_in_years']
    return students.rename(
        columns={ old_column_names[i]: new_column_names[i] for i in range(len(new_column_names)) }
    )
