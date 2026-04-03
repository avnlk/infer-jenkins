import json
import os

print("Working directory:", os.getcwd())

issues = []

for report_file in ['infer-out-c-report.json', 'infer-out-java-report.json']:
    if os.path.exists(report_file):
        with open(report_file) as f:
            issues.extend(json.load(f))
        print(f"Loaded {report_file}")
    else:
        print(f"Warning: {report_file} not found, skipping")

output_path = os.path.join(os.getcwd(), 'infer-report.txt')
with open(output_path, 'w') as out:
    for i in issues:
        out.write(f"{i['file']}:{i['line']}: warning: [{i['bug_type']}] {i['qualifier']}\n")

print("Written to:", output_path)
print("Total issues written:", len(issues))
