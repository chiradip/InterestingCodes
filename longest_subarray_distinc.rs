pub fn longest_subarray_distinct(arr: &[i32]) -> usize {
    let mut window_start :usize = 0;
    let mut window_content : HashMap<i32,usize> = HashMap::with_capacity(100); // HashMap::new();

    let mut longest :usize= 0;

    for (window_end, elem) in arr.iter().enumerate() {
        let key_option = window_content.get(&elem);
        window_start = match key_option {
            Some(value) =>
                max(window_start,value+1),
            None => window_start // println!("No value for key = {}", &arr[window_end])
        };
        println!("Window Start = {}, Window End = {}", window_start, window_end);
        longest = max(longest, window_end - window_start + 1);
        window_content.insert(*elem, window_end);
    }
    longest
}
