import time

start_time = time.time()
file = open('schedule.xml', 'r', encoding="utf-8")
xml = file.read()
print(xml)

for i in xml:
    if "<schedule>":
        xml = xml.replace("<schedule>", 'schedule: {', 1)
        xml = xml.replace("</schedule>", '}', 1)

    if '<firstlesson>':
        xml = xml.replace("<firstlesson>", '\"firstlesson\": {', 1)
        xml = xml.replace("</firstlesson>", '},', 1)

    if '<secondlesson>':
        xml = xml.replace("<secondlesson>", '\"secondlesson\": {', 1)
        xml = xml.replace("</secondlesson>", '}', 1)

    if '<name>':
        xml = xml.replace('<name>', '\"name\": \"', 1)
        xml = xml.replace('</name>', '\",', 1)

    if '<time>':
        xml = xml.replace('<time>', '\"time\": \"', 1)
        xml = xml.replace('</time>', '\",', 1)

    if '<place>':
        xml = xml.replace('<place>', '\"place\": \"', 1)
        xml = xml.replace('</place>', '\",', 1)

    if '<teacher>':
        xml = xml.replace('<teacher>', '\"teacher\": \"', 1)
        xml = xml.replace('</teacher>', '\",', 1)

    if '<format>':
        xml = xml.replace('<format>', '\"format\": \"', 1)
        xml = xml.replace('</format>', '\"', 1)
print(xml)

print("--- %s seconds ---" % (time.time() - start_time))
