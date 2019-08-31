- Put back all HR related converters and validators back into sm-lib(eg activeEmployeeConverter)
- Move the UI code for the management of user preferences including modules and
  privileges to the JMTS. The SM should not have "knowledge" of other modules.
- Impl system-management lib and use it instead of WAL.
- Implement PF status monitor for file downloads and remove code the deals with it otherwise.
