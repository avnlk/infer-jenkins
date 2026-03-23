import json

with open('infer-out/report.json') as f:
    issues = json.load(f)

with open('infer-out/report.txt', 'w') as out:
    for i in issues:
        out.write(f"{i['file']}:{i['line']}: warning: [{i['bug_type']}] {i['qualifier']}\n")  
