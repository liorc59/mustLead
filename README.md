# mustLead
Get the mustLead of a graph when given the entry and goal nodes.

You can look at src/test/java/MustLeadTests.java to see the format that the sever expect.

The sever run on port 8080.


An exemple for a request:
```
{
	"entry": "5",
	"node": "3",
	"graph": "{\ntoval->1\n1->2\n2->3\n3->5\n2->5\n5->2\n}"
}
```

Note that there is a \n before and after every eadge defination.
