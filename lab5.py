import re

def main():
    pattern = r'".+sportszone.+gif"'
    regex = re.compile(pattern)
    count = 0
    with open("logfile") as file:
        for line in file:
            match = regex.search(line)
            if match:
                count += 1
                print(line)

    print("Count:", count)

if __name__ == "__main__":
    main()
