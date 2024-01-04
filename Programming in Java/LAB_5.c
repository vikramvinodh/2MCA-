#include <stdio.h>
#include <string.h>

// Define a structure for construction project information
struct ConstructionProject {
    char projectName[50];
    int projectID;
    int constructionStartDate; 
    float estimatedBudget;
};

// Function to perform linear search
int linearSearch(struct ConstructionProject projects[], int n, int key, int *elementComparisons, int *indexComparisons) {
    for (int i = 0; i < n; i++) {
        (*elementComparisons)++;
        if (projects[i].projectID == key || projects[i].constructionStartDate == key) {
            (*indexComparisons)++;
            return i; // Element found, return index
        }
        (*indexComparisons)++;
    }
    return -1; // Element not found
}

// Function to perform sentinel search
int sentinelSearch(struct ConstructionProject projects[], int n, int key, int *elementComparisons, int *indexComparisons) {
    int last = n - 1;
    struct ConstructionProject temp = projects[last]; // Save the last element
    projects[last].projectID = key; // Set sentinel for projectID
    projects[last].constructionStartDate = key; // Set sentinel for constructionStartDate

    int i = 0;
    while (projects[i].projectID != key && projects[i].constructionStartDate != key) {
        (*elementComparisons)++;
        i++;
        (*indexComparisons)++;
    }

    projects[last] = temp; // Restore the last element

    if (i < last || projects[last].projectID == key || projects[last].constructionStartDate == key) {
        return i; // Element found, return index
    } else {
        return -1; // Element not found
    }
}

// Function to perform binary search
int binarySearch(struct ConstructionProject projects[], int left, int right, int key, int *elementComparisons, int *indexComparisons) {
    while (left <= right) {
        int mid = left + (right - left) / 2;
        (*elementComparisons)++;
        if (projects[mid].projectID == key || projects[mid].constructionStartDate == key) {
            (*indexComparisons)++;
            return mid; // Element found, return index
        } else if (projects[mid].projectID < key) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
        (*indexComparisons)++;
    }
    return -1; // Element not found
}

// Function to perform bubble sort
void bubbleSort(struct ConstructionProject projects[], int n, int *comparisons, int *dataTransfers) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            (*comparisons)++;
            if (projects[j].projectID > projects[j + 1].projectID) {
                // Swap the elements
                struct ConstructionProject temp = projects[j];
                projects[j] = projects[j + 1];
                projects[j + 1] = temp;
                (*dataTransfers)++;
            }
        }
    }
}

// Function to perform insertion sort
void insertionSort(struct ConstructionProject projects[], int n, int *comparisons, int *dataTransfers) {
    for (int i = 1; i < n; i++) {
        struct ConstructionProject key = projects[i];
        int j = i - 1;

        while (j >= 0 && (projects[j].projectID > key.projectID || projects[j].constructionStartDate > key.constructionStartDate)) {
            (*comparisons)++;
            // Move elements greater than key to one position ahead
            projects[j + 1] = projects[j];
            (*dataTransfers)++;
            j = j - 1;
        }
        projects[j + 1] = key;
        (*dataTransfers)++;
    }
}

int main() {
    // Sample data for construction projects
    struct ConstructionProject projects[] = {
        {"Project A", 101, 20220101, 150000.0},
        {"Project B", 204, 20220315, 200000.0},
        {"Project C", 303, 20220120, 120000.0},
        {"Project D", 402, 20220410, 180000.0},
        // Add more data as needed
    };

    int n = sizeof(projects) / sizeof(projects[0]);

    // Sorting before binary search
    int bubbleComparisons = 0, bubbleTransfers = 0;
    bubbleSort(projects, n, &bubbleComparisons, &bubbleTransfers);

    int insertionComparisons = 0, insertionTransfers = 0;
    insertionSort(projects, n, &insertionComparisons, &insertionTransfers);

    // Linear search
    int linearKeyProjectID = 303;
    int linearElementComparisonsProjectID = 0, linearIndexComparisonsProjectID = 0;
    int linearIndexProjectID = linearSearch(projects, n, linearKeyProjectID, &linearElementComparisonsProjectID, &linearIndexComparisonsProjectID);

    int linearKeyStartDate = 20220315;
    int linearElementComparisonsStartDate = 0, linearIndexComparisonsStartDate = 0;
    int linearIndexStartDate = linearSearch(projects, n, linearKeyStartDate, &linearElementComparisonsStartDate, &linearIndexComparisonsStartDate);

    // Sentinel search
    int sentinelKeyProjectID = 204;
    int sentinelElementComparisonsProjectID = 0, sentinelIndexComparisonsProjectID = 0;
    int sentinelIndexProjectID = sentinelSearch(projects, n, sentinelKeyProjectID, &sentinelElementComparisonsProjectID, &sentinelIndexComparisonsProjectID);

    int sentinelKeyStartDate = 20220120;
    int sentinelElementComparisonsStartDate = 0, sentinelIndexComparisonsStartDate = 0;
    int sentinelIndexStartDate = sentinelSearch(projects, n, sentinelKeyStartDate, &sentinelElementComparisonsStartDate, &sentinelIndexComparisonsStartDate);

    // Binary search
    int binaryKeyProjectID = 402;
    int binaryElementComparisonsProjectID = 0, binaryIndexComparisonsProjectID = 0;
    int binaryIndexProjectID = binarySearch(projects, 0, n - 1, binaryKeyProjectID, &binaryElementComparisonsProjectID, &binaryIndexComparisonsProjectID);

    int binaryKeyStartDate = 20220410;
    int binaryElementComparisonsStartDate = 0, binaryIndexComparisonsStartDate = 0;
    int binaryIndexStartDate = binarySearch(projects, 0, n - 1, binaryKeyStartDate, &binaryElementComparisonsStartDate, &binaryIndexComparisonsStartDate);

    // Display results
    printf("Linear Search for Project ID:\n");
    printf("Key %d found at index %d\n", linearKeyProjectID, linearIndexProjectID);
    printf("Element Comparisons: %d\n", linearElementComparisonsProjectID);
    printf("Index Comparisons: %d\n\n", linearIndexComparisonsProjectID);

    printf("Linear Search for Start Date:\n");
    printf("Key %d found at index %d\n", linearKeyStartDate, linearIndexStartDate);
    printf("Element Comparisons: %d\n", linearElementComparisonsStartDate);
    printf("Index Comparisons: %d\n\n", linearIndexComparisonsStartDate);

    printf("Sentinel Search for Project ID:\n");
    printf("Key %d found at index %d\n", sentinelKeyProjectID, sentinelIndexProjectID);
    printf("Element Comparisons: %d\n", sentinelElementComparisonsProjectID);
    printf("Index Comparisons: %d\n\n", sentinelIndexComparisonsProjectID);

    printf("Sentinel Search for Start Date:\n");
    printf("Key %d found at index %d\n", sentinelKeyStartDate, sentinelIndexStartDate);
    printf("Element Comparisons: %d\n", sentinelElementComparisonsStartDate);
    printf("Index Comparisons: %d\n\n", sentinelIndexComparisonsStartDate);

    printf("Binary Search for Project ID:\n");
    printf("Key %d found at index %d\n", binaryKeyProjectID, binaryIndexProjectID);
    printf("Element Comparisons: %d\n", binaryElementComparisonsProjectID);
    printf("Index Comparisons: %d\n\n", binaryIndexComparisonsProjectID);

    printf("Binary Search for Start Date:\n");
    printf("Key %d found at index %d\n", binaryKeyStartDate, binaryIndexStartDate);
    printf("Element Comparisons: %d\n", binaryElementComparisonsStartDate);
    printf("Index Comparisons: %d\n\n", binaryIndexComparisonsStartDate);

    printf("Bubble Sort:\n");
    printf("Comparisons: %d\n", bubbleComparisons);
    printf("Data Transfers: %d\n\n", bubbleTransfers);

    printf("Insertion Sort:\n");
    printf("Comparisons: %d\n", insertionComparisons);
    printf("Data Transfers: %d\n\n", insertionTransfers);

    return 0;
}
