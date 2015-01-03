# Cordova 3.x Contact Picker Plugin #
This plugin brings up a native iOS or Android contact-picker overlay, accessing the addressbook and returning the selected contact's name, email and phone number.

## Usage

Example Usage

````javascript
window.plugins.ContactPickerPlugin.pickContact({
 success: function (contactInfo) {
  // Use timeout to fix the iOS alert problem.
  setTimeout(function () {alert(contactInfo.displayName + " " + contactInfo.email + " " + contactInfo.phoneNumber)}, 0)
 },
 error: function (errormessage) {
  console.log (errormessage)
 }
})
````

The method which will return a JSON. Example:
````json
{
 displayName : "John Doe",
 email       : "john.doe@mail.com",
 phoneNumber : "012-345-6789"
}
````

## Requirements

This works with Cordova 3.0+ and has been successfully tested for (3.6.3).

## Installation Instructions

The ContactPicker plugin provides support for Cordova's command-line tooling.
Simply navigate to your project's root directory and execute the following command:

````
cordova plugin add https://github.com/agamemnus/ContactPickerPlugin.git
````
## MIT License (Android)

Copyright 2015 Michael Romanovsky

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

## MIT License (iOS portion)

Copyright 2013 Monday Consulting GmbH

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
