#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main() {
	int n;
	int result = 0;
	char *word = malloc(sizeof(char) * 1024);
	scanf("%d", &n);
	
	
	int i = 0;
	for (i=0; i<n; i++) {
		//printf("i : %d\n", i);
		scanf("%s", word);
		int length = strlen(word);
		int j = 0;
		for (j = 0; j < length ; j++) {
			if (j + 1 < length && word[j] == word[j + 1]) continue;
			int k = j+1;
			while (k < length) {
				if (word[j] == word[k]) {
					goto out;
				}
				k++;
			}
		}
		result++;
	out:
		;
	}

	printf("%d",result);
	return 0;
}