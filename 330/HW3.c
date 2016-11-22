#include <stdlib.h>
#include <string.h>
#include <limits.h>
#include <stdio.h>
typedef struct Huff
{
	char c;
	int freq;
	struct Huff * next;
	struct Huff * left;
	struct Huff * right;
	char * encoding;
	char * chars;
}Huff;

int main(int argc, char ** argv, char ** envp)
{
	// Used https://www.tutorialspoint.com/c_standard_library/c_function_fgetc.htm
	// as a reference for the reading of the characters from the file
	FILE * file = fopen(argv[1], "r");
	printf("File Opened\n");
	int ch;
	Huff * head = malloc(sizeof(Huff));
	Huff * current = malloc(sizeof(Huff));

	int listCount = 0;

	////////// List Creation //////////
	if(file == NULL)
	{
		printf("Error in opening file\n");
		return(-1);
	}
	do
	{
		ch = fgetc(file);
		printf("letter read: %c\n", ch);
		if(feof(file))
		{
			break;
		}
		if(ch == NULL)
		{
			printf("Inside the check\n");
			continue;
		}
		else if(head == NULL)
		{
			Huff * node = malloc(sizeof(Huff));
			node->c = ch;
			node->freq = 1;
			node->next = NULL;
			node->left = malloc(sizeof(Huff));
			node->right = malloc(sizeof(Huff));
			node->chars = malloc(100);
			node->encoding = malloc(100);
			head = node;
			listCount++;
			continue;
		}
		current = head;
		int done = 0;

		while(done == 0)
		{
			if(current->c == ch)
			{
				current->freq++;
				done = 1;
			}
			else if(current->next == NULL)
			{
				Huff * node = malloc(sizeof(Huff));
				node->c = ch;
				node->freq = 1;
				node->next = NULL;
				node->left = malloc(sizeof(Huff));
				node->right = malloc(sizeof(Huff));
				node->chars = malloc(100);
				node->encoding = malloc(100);
				current->next = malloc(sizeof(Huff));
				current->next = node;
				listCount++;	
				done = 1;
			}
			else
			{
				current = current->next;	
			}
		}		
	}while(1);
	current = head;
	while(current != NULL)
	{
		printf("current: c=%c - freq=%d*\n",current->c, current->freq);
		current = current->next;
	}
	fclose(file);
	printf("File Closed\n");
	////////// End of List Creation //////////

	////////// Finding Smallest Values //////////
	printf("Inside next section\n");
	Huff * prev = malloc(sizeof(Huff));
	current = head;
	Huff * node1 = malloc(sizeof(Huff));
	Huff * node2 = malloc(sizeof(Huff));
	int done = 0;
	while(done == 0)
	{
		printf("Inside loop\n");
		printf("current: %c\n",current->c );
		node1->freq = 0;
		node2->freq = 0;
		if(current->freq == 0)
		{
			current = current->next;
			continue;
		}

		////////// Loop Through All Items to Get 2 Smallest Values //////////
		while(current != NULL)
		{
			printf("node1 c: %c\n",node1->c );
			printf("node2 c: %c\n",node2->c );
			printf("current2: %c\n",current->c );

			if(node1->freq == 0 || current->freq < node1->freq)
			{
				printf("Test1\n");
				if(current->c == '\0')
				{
					printf("Test2\n");
					node1->chars = current->chars;
					node1->freq = current->freq;
				}
				else
				{
					printf("Test3\n");
					node1->c = current->c;
					node1->freq = current->freq;
				}
				
			}
			else if(node2->freq == 0 || current->freq < node2->freq)
			{
				printf("Test1\n");
				if(current->c == '\0')
				{
					printf("Test2\n");
					node2->chars = current->chars;
					node2->freq = current->freq;
				}
				else
				{
					printf("Test3\n");
					node2->c = current->c;
					node2->freq = current->freq;
				}
				
			}
			current = current->next;
		}
		printf("Outside\n");

		////////// End of Loop Through All Items to Get 2 Smallest Values //////////

		////////// Combine and Remove Smallest Nodes //////////
		current = head;
		int fin = 0;
		int doneCount = 0;
		printf("\n\n\n");
		while(current != NULL && fin == 0)
		{
			printf("\nInside  next spot\n");
			printf("node1 c: %c\n",node1->c );
			// printf("node1 chars: %c\n",node1->chars );
			printf("node1->freq: %d\n",node1->freq );
			printf("node2 c: %c\n",node2->c );
			// printf("node2 chars: %c\n",node2->chars );
			printf("node2->freq: %d\n",node2->freq );
			printf("current2: %c\n",current->c );
			if(current->c == NULL )
			{
				printf("Inside null check\n");
				prev = current;
				current = current->next;
				prev->next = current;
				continue;
			}
			printf("Above ifs\n");
			if(node1->c == current->c)
			{
				printf("test1\n");
				node1 == current; 
				if(current == head)
				{
					printf("test2\n");
					current = current->next;
				}
				else
				{
					printf("test3\n");
					prev->next = current->next;
					current = current->next;

				}
				doneCount++;
			}
			else if(node2->c == current->c)
			{
				printf("test4\n");
				node2 == current; 
				if(current == head)
				{
					printf("test5\n");
					current = current->next;
				}
				else
				{
					printf("test6\n");
					prev->next = current->next;
					current = current->next;
				}
				doneCount++;
			}
			else
			{
				printf("Inside the next iterator\n");
				prev = prev->next;
				current = current->next;				
			}
			if(doneCount == 2)
			{
				printf("test7\n");
				fin = 1;		
			}

		}
		printf("Down here\n\n");
		printf("node1->freq: %d\n", node1->freq);
		printf("node2->freq: %d\n", node2->freq);
		current = head;
		Huff * combNode = malloc(sizeof(Huff));
		char zeroChar = '0';
		char oneChar = '1';
		// while(current != NULL)
		// {
		// 	printf("current->c: %c\n", current->c);
		// 	if(current->next == NULL)
		// 	{
		// 		current->next = combNode;
		// 		break;
		// 	}
		// 	current = current->next;
		// }
		// current = combNode;
		if(node1->c != '\0')
		{
			printf("test1\n");
			combNode->chars = malloc(5);
			strcpy(combNode->chars, &node1->c);
			printf("combNode->chars: %s\n", combNode->chars);
		}
		else
		{
			printf("test2\n");
			combNode->chars = node1->chars;
		}
		if(node2->c != '\0')
		{
			printf("test3\n");
			strcat(combNode->chars, &node2->c);
			printf("combNode->chars: %s\n", combNode->chars);
			printf("node1->freq: %d\n", node1->freq);
		}
		else
		{
			printf("test4\n");
			strcat(combNode->chars, node2->chars);
		}
		node1->encoding = malloc(100);
		node2->encoding = malloc(100);
		if(node1->freq <= node2->freq)
		{
			printf("test5\n");
			combNode->left = node1;
			if(node1->encoding == NULL)
			{
				strcpy(node1->encoding, &zeroChar);
			}
			else
			{
				strcat(node1->encoding, &zeroChar);
			}
			if(node2->encoding == NULL)
			{
				strcpy(node2->encoding, &oneChar);
			}
			else
			{
				strcat(node2->encoding, &oneChar);
			}
			combNode->right = node2;
		}
		else
		{
			printf("test6\n");
			combNode->left = node2;
			if(node2->encoding == NULL)
			{
				strcpy(node2->encoding, &zeroChar);
			}
			else
			{
				strcat(node2->encoding, &zeroChar);
			}
			if(node1->encoding == NULL)
			{
				strcpy(node1->encoding, &oneChar);
			}
			else
			{
				strcat(node1->encoding, &oneChar);
			}
			combNode->right = node1;
		}
		printf("Got here\n");
		current = head;
		printf("\n\n");
		printf("combNode->chars%s\n",combNode->chars );
		while(current->next != NULL)
		{
			printf("current->c: %c\n", current->c);
			current = current->next;
		}
		printf("current->c: %c\n", current->c);
		combNode->next = NULL;
		current->next = combNode;
		printf("endingItemIs: %s\n",current->chars );
		printf("End of the stuff\n");
		printf("\n\n");
		////////// End of Combine and Remove Smallest Nodes //////////
	}
	////////// End of Finding Smallest Values //////////
}