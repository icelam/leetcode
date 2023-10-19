import pandas as pd

def fillMissingValues(products: pd.DataFrame) -> pd.DataFrame:
    result_dataframe = pd.DataFrame(products)
    result_dataframe['quantity'].fillna(0, inplace=True)
    return result_dataframe
