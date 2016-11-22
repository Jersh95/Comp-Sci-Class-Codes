#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#include <unistd.h>
#include <sys/wait.h>

typedef struct ParseResult{
	char ** arguments;
	int * argCount;
}ParseResult;

ParseResult * parse(char * string, char * delimiter);

int main(int argc, char ** argv, char ** envp)
{
	bool good = true;
	printf("Welcome to my shell, enter a command...IF YOU DARE TEST ME!\n");
	printf("If you cannot handle this, enter 'q' to quit...you will only be labeled as a quitter...\n");

	while(good)
	{
		char * input = malloc(199);
		char * delimiter = malloc(1);
		
		printf("SUPA SHELL $ ");
		scanf("%[^\n]199", input);

		if(*input == 'q')
		{
			printf("MUWAHAHAHAHA...you could not handle the shell's power! FAREWELL TRAVELER!\n");
			good = false;
			continue;
		}

		*delimiter = ' ';

		getchar();
		ParseResult * result = malloc(sizeof(ParseResult));
		printf("Command arguments: \n");
		result = parse(input, delimiter);

		int envCount = 0;
		char * path;
		char * test = malloc(6);
		int len = 0;
		int done = 0;
		while(envp[envCount] != 0 && done == 0)
		{
			test = strncpy(test, envp[envCount], 5);
			int count = 5;
			if(strcmp(test, "PATH=") == 0)
			{
				while(envp[envCount][count] != 0)
				{
					len++;
					count++;
				}
				path = malloc(len * sizeof(char) +1);
				strncpy(path, &envp[envCount][5], len);
				done = 1;
			}
			envCount ++;
		}

		done = 0;
		*delimiter = ':';

		ParseResult * filePaths = malloc(sizeof(ParseResult));
		printf("Path arguments: \n");
		filePaths = parse(path, delimiter);
		int count = 0;
		
		for(int i = 0; i <= *filePaths->argCount; i++)
		{			
			strcat(filePaths->arguments[i], "/");
			strcat(filePaths->arguments[i], result->arguments[0]);
			printf("Checking: %s\n", filePaths->arguments[i]);
			if(access(filePaths->arguments[i], F_OK) != -1)
			{
				int frk = fork();
				if(frk==0)
				{
					printf("\nFound!\n\n");
					execv(filePaths->arguments[i], result->arguments);
				}
				else
				{
					wait(&frk);
					break;
				}	
				break;
			}
		}
	}
}

ParseResult * parse(char * string, char * delimiter)
{
	char * other = string;
	char * other2 = other;
	int done = 0;
	int count;
	int len;
	int argsCount = 0;
	int numArgs = 0;
	int spaces = 0;

	ParseResult * result = malloc(sizeof(ParseResult));

	while(done == 0)
	{
		char * contents = malloc(sizeof(char)*199);
		count = 0;
		spaces = 0;
		while(*other != *delimiter && *other != 0)
		{
			contents[count] = *other;
 			other++;
 			count++;
			
		}

		len = other - string;
		if(*other == 0)
		{
			done = 1;
		}
		else
		{
			other ++;//skip space
			string = other;
			numArgs ++;
		}
	}
	numArgs++;

	result->arguments = malloc(numArgs * sizeof(char *));
	result->argCount = malloc(numArgs * sizeof(int));
	*result->argCount = numArgs;
	
	done = 0;
	int fileFound = 0;
	other = other2;
	int check = 0;
	while(done == 0)
	{
		char * contents = malloc(sizeof(char)*199);
		count = 0;
		spaces = 0;
		check = 0;
		while(*other != 0 && *other != *delimiter)
		{	
			contents[count] = *other;
 			other++;
 			count++;	
		}

		len = other - other2;

		if(*other == 0)
		{
			result->arguments[argsCount] = malloc(len * sizeof(char)+1);
			strncpy(result->arguments[argsCount], contents, len);
			other2 = other;

			for(int i=0; i <= argsCount; i++)
			{
				printf("Argument[%d]: %s\n",i, result->arguments[i] );
			}
			printf("\n");
			done = 1;
		}
		result->arguments[argsCount] = malloc(len * sizeof(char)+1);
		strncpy(result->arguments[argsCount], contents, len);	
		other++;
		other2 = other;
		argsCount ++;
	}
	return result;
}