# Allure Reports - Simple Guide

## Generate Report

```bash
mvn clean test
mvn allure:serve
```

This will open the report in your browser showing:
- Test results
- Pass/Fail status
- Execution time
- Test features and stories

## View Report Without Opening Browser

```bash
mvn allure:report
```

Open: `target/site/allure-report/index.html`

## What You'll See

- Test name
- Status (PASSED/FAILED)
- Duration
- Feature: Contact Management
- Story: Create Contact

