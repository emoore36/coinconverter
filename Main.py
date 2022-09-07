import sys


COIN_MAP: dict = {}
CONVERSION_RATE: int = 10

# region abstracted code


def calculate_conversion_num(coin_type: str) -> int:
    """Returns the number of times the given coin will be converted to its superior.

    Args:
        coin_type (str): the type of coin to convert from

    Returns:
        int: the number of times to convert
    """
    return int(COIN_MAP[coin_type] / 10)


def decrement_coin(coin_type: str, num: int):
    """Removes a number of the given coin determined by the number of conversions and the conversion rate.

    Args:
        coin_type (str): the type of coin to decrement
        num (int): the number of times the coin is to be converted
    """
    if coin_type in COIN_MAP:
        COIN_MAP[coin_type] = COIN_MAP[coin_type] - (num * CONVERSION_RATE)
        if COIN_MAP[coin_type] == 0:
            COIN_MAP.pop(coin_type)


def increment_coin(coin_type: str, num: int):
    """Increases the given coin by the given amount.

    Args:
        coin_type (str): The coin to increment
        num (int): the amount by which to increment
    """
    if coin_type in COIN_MAP:
        COIN_MAP[coin_type] += num
    else:
        COIN_MAP[coin_type] = num
    if COIN_MAP[coin_type] == 0:
        COIN_MAP.pop(coin_type)


def convert_coin(from_coin: str, to_coin: str):
    """Converts currency between two coins

    Args:
        from_coin (str): The coin from which to convert
        to_coin (str): The coin to which to convert
    """
    # calculate the number of times to convert coins
    num_of_conversions: int = calculate_conversion_num(from_coin)

    decrement_coin(from_coin, num_of_conversions)
    increment_coin(to_coin, num_of_conversions)


# endregion

for arg in sys.argv[1:]:
    coin_num = int(arg[:-2])
    coin_type = arg[-2:]

    COIN_MAP[coin_type] = coin_num

# convert cp to sp
convert_coin("cp", "sp")

# convert sp to gp
convert_coin("sp", "gp")


output: str = ""

for coin_type in COIN_MAP:
    output += str.format("{}{} ", COIN_MAP[coin_type], coin_type)

print(output)
