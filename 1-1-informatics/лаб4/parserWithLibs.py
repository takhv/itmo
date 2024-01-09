import json
import xmltodict
import time

start_time = time.time()
with open("schedule.xml", encoding="utf-8") as xml_file:
    data_dict = xmltodict.parse(xml_file.read())
    xml_file.close()

    json_data = json.dumps(data_dict)

    with open("schedule1.json", "w") as json_file:
        json_file.write(json_data)
        json_file.close()

print("--- %s seconds ---" % (time.time() - start_time))
