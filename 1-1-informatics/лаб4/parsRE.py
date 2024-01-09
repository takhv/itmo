import time
import re

start_time = time.time()
file = open('schedule.xml', 'r', encoding="utf-8")
xml = file.read()
print(xml)

a = re.findall(r'<\w*>', xml)
arr = []
for i in range(len(a)-1):
    if a[i] == a[i+1]:
        arr.append(a[i+1])
if arr[0] in xml:
    xml = xml.replace(arr[0], '\"times\": [\"', 1)
print(arr)
print(a)

json = re.sub(r'</f.*on>', '},', xml)
json = re.sub(r'</s.*>', '}', json)

json = re.sub(r'<.*le>', 'schedule: {', json)
json = re.sub(r'on>', 'on\": {', json)

json = re.sub(r'</.*t>', '\"', json)
json = re.sub(r'</.*>', '\",', json)
json = re.sub(r'>', '\": \"', json)
json = re.sub(r'<', '\"', json)
if '\"time\"' in json:
    json = json.replace('\"time\":', ' ', 1)

if '\"time\"' in json:
    json = json.replace('\"time\":', ' ', 1)
if '\"time\"' in json:
    json = json.replace('\"time\":', ' ', 1)
if 'O\",' in json:
    json = json.replace('O\",', '0\"],', 1)

print(json)

print("--- %s seconds ---" % (time.time() - start_time))
