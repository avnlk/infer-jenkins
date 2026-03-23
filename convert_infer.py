import json
import os

print("Working directory:", os.getcwd())

with open('infer-out/report.json') as f:
    issues = json.load(f)

output_path = os.path.join(os.getcwd(), 'infer-report.txt')
with open(output_path, 'w') as out:
    for i in issues:
        out.write(f"{i['file']}:{i['line']}: warning: [{i['bug_type']}] {i['qualifier']}\n")

print("Written to:", output_path)
print("Issues written:", len(issues))
