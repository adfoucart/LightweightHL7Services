# Lightweight HL7 Services

Very basic GUI to send & receive HL7 messages using [HAPI](https://hapifhir.github.io/hapi-hl7v2/).

Features:

* Open file as text & display content in the interface.
* Send content of the textarea as an HL7 message to specified host & port.
* Start HL7 listener & display incoming connections & received messages in the interface.

Note that this application does absolutely nothing to check the contents of the messages, or to do anything with it. 
This is just a quick way of starting an HL7 client/server to test other applications (as the HAPI Test Panel can be a little bit buggy at times...).

Code developed by Adrien Foucart as part of the INFO-H-400 Medical Information Systems teaching material. 
It is very unlikely to be maintained in this repository beyond 2022.
