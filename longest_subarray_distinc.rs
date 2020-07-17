pub fn longest_subarray_distinct(arr: &[i32]) -> i32 {
    let mut window_start :usize = 0;
    let mut window_content : HashMap<i32,usize> = HashMap::new(); //with_capacity(100); // HashMap::new();

    let mut longest= 0;

    for window_end in 0..arr.len() {
        let key_option = window_content.get(&arr[window_end]);
        window_start = match key_option {
            Some(value) =>
                max(window_start, value+1),
            None => window_start // println!("No value for key = {}", &arr[window_end])
        };
        println!("Window Start = {}, Window End = {}", window_start, window_end);
        longest = max(longest, window_end - window_start + 1);
        window_content.insert(arr[window_end], window_end);
    }
    longest as i32
}
